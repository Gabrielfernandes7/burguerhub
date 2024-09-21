<script lang="ts" setup>

import { ref, reactive, onMounted } from 'vue';
import ButtonSubmitFormCustomer from '../../atoms/ButtonSubmitFormCustomer/ButtonSubmitFormCustomer.vue';
import Message from '../../atoms/Message/Message.vue';

type Ingrediente = {
  id: number;
  tipo: string;
}

type BurgerData = {
  nome: string | null;
  carne: string | null;
  pao: string | null;
  opcionais: string[];
  status: string;
}

const paes = ref<Ingrediente[] | null>(null);
const carnes = ref<Ingrediente[] | null>(null);
const opcionaisdata = ref<Ingrediente[] | null>(null);
const nome = ref<string | null>(null);
const pao = ref<string | null>(null);
const carne = ref<string | null>(null);
const opcionais = ref<string[]>([]);
const status = ref<string>("Solicitado");
const message = ref<string | null>(null);

// Função para obter ingredientes
const getIngredientes = async () => {
  const req = await fetch('http://localhost:3000/ingredientes');
  const data = await req.json();

  paes.value = data.paes;
  carnes.value = data.carnes;
  opcionaisdata.value = data.opcionais;
};

// Função para criar o burger
const createBurger = async (e: Event) => {
  e.preventDefault();

  const data: BurgerData = {
    nome: nome.value,
    carne: carne.value,
    pao: pao.value,
    opcionais: Array.from(opcionais.value),
    status: "Solicitado"
  };

  const dataJson = JSON.stringify(data);

  const req = await fetch("http://localhost:3000/burgers", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: dataJson
  });

  const res = await req.json();
  console.log(res);

  message.value = "Pedido realizado com sucesso!";

  // Limpar a mensagem após 3 segundos
  setTimeout(() => {
    message.value = "";
  }, 3000);

  // Limpar campos do formulário
  nome.value = "";
  carne.value = "";
  pao.value = "";
  opcionais.value = [];
};

// Chamar a função ao montar o componente
onMounted(() => {
  getIngredientes();
});

</script>

<template>
    <div>
        <Message 
          :message="message" 
          v-show="message" 
        />
        <form method="post"
            @submit="createBurger"
            class="form-control bg-dark"
            id="burger-form"
            action="">
            <div class="input-container">
                <label for="nome">Nome do cliente:</label>
                <input 
                    type="text" 
                    id="nome" 
                    name="nome" 
                    v-model="nome"
                    placeholder="Digite o seu nome">
            </div>

            <div class="input-container">
                <label for="pao">Escolha o pão:</label>
                <select name="pao" id="pao" v-model="pao">
                  <option value="">Selecione o seu pão</option>
                  <option 
                    v-for="pao in paes" 
                    :key="pao.id" 
                    :value="pao.tipo">{{ pao.tipo }}</option>
                </select>
            </div>

            <div class="input-container">
                <label for="carne">Escolha a carne do seu Burger:</label>
                <select name="carne" id="carne" v-model="carne">
                  <option value="">Selecione o tipo de carne</option>
                  <option 
                    v-for="carne in carnes" 
                    :key="carne.id" 
                    :value="carne.tipo">
                      {{ carne.tipo }}
                  </option>
                </select>
            </div>

            <div id="opcionais-container" class="input-container">
              <label id="opcionais-title" for="opcionais">Selecione os opcionais:</label>
              <div class="checkbox-container" v-for="opcional in opcionaisdata" :key="opcional.id">
                <input type="checkbox" name="opcionais" v-model="opcionais" :value="opcional.tipo">
                <span>{{ opcional.tipo }}</span>
              </div>
            </div>

            <ButtonSubmitFormCustomer />
        </form>
    </div>
</template>

<style scoped>
#burger-form {
  max-width: 25rem;
  margin: 2.5vh auto 5vh;

  color: white;
}
</style>