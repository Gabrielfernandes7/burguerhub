<script lang="ts">
export default {
  name: "DashboardComponent",
  data() {
    return {
      burgers: null,
      burger_id: null,
      status: [],
    };
  },
  methods: {
    async getPedidos() {
      const req = await fetch('http://localhost:3000/burgers');
      const data = await req.json();
      this.burgers = data;

      // Resgata os status de pedidos
      this.getStatus();
    },
    async getStatus() {
      const req = await fetch('http://localhost:3000/status');
      const data = await req.json();
      this.status = data;
    },
    async deleteBurger(id) {
      const req = await fetch(`http://localhost:3000/burgers/${id}`, {
        method: "DELETE"
      });
      const res = await req.json();
      console.log(res);
      this.getPedidos();
    },
    async updateBurger(event: Event, id: number) {
      const target = event.target as HTMLSelectElement;
      const option = target.value;

      const dataJson = JSON.stringify({ status: option });

      const req = await fetch(`http://localhost:3000/burgers/${id}`, {
        method: "PATCH",
        headers: { "Content-Type": "application/json" },
        body: dataJson
      });

      const res = await req.json();
      console.log(res);
    }
  },
  mounted() {
    this.getPedidos();
  }
};
</script>

<template>
  <div v-if="burgers" class="container mt-5">
    <h2 class="mb-4">Lista de Pedidos</h2>
    <table class="table table-striped table-bordered">
      <thead class="table-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Cliente</th>
          <th scope="col">Pão</th>
          <th scope="col">Carne</th>
          <th scope="col">Opcionais</th>
          <th scope="col">Ações</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="burger in burgers" :key="burger.id">
          <th scope="row">{{ burger.id }}</th>
          <td>{{ burger.nome }}</td>
          <td>{{ burger.pao }}</td>
          <td>{{ burger.carne }}</td>
          <td>
            <ul>
              <li v-for="(opcional, index) in burger.opcionais" :key="index">{{ opcional }}</li>
            </ul>
          </td>
          <td>
            <select name="status" class="form-select" @change="updateBurger($event, burger.id)">
              <option :value="s.tipo" v-for="s in status" :key="s.id" :selected="burger.status == s.tipo">
                {{ s.tipo }}
              </option>
            </select>
            <button class="btn btn-danger ms-2" @click="deleteBurger(burger.id)">Cancelar</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <div v-else class="container mt-5">
    <h2>Não há pedidos no momento!</h2>
  </div>
</template>

  
<style scoped>
  #burger-table {
    max-width: 1200px;
    margin: 20vh auto;
  }

  #burger-table-heading,
  #burger-table-rows,
  .burger-table-row {
    display: flex;
    flex-wrap: wrap;
  }

  #burger-table-heading {
    font-weight: bold;
    padding: 12px;
    border-bottom: 3px solid #333;
  }

  .burger-table-row {
    width: 100%;
    padding: 12px;
    border-bottom: 1px solid #CCC;
  }

  #burger-table-heading div,
  .burger-table-row div {
    width: 19%;
  }

  #burger-table-heading .order-id,
  .burger-table-row .order-number {
    width: 5%;
  }

  select {
    padding: 12px 6px;
    margin-right: 12px;
  }

  .delete-btn {
    background-color: #222;
    color:#fcba03;
    font-weight: bold;
    border: 2px solid #222;
    padding: 10px;
    font-size: 16px;
    margin: 0 auto;
    cursor: pointer;
    transition: .5s;
  }
  
  .delete-btn:hover {
    background-color: transparent;
    color: #222;
  }
  
</style>