<script lang="ts">
export default {
  name: "MessageAlert",
  props: {
    message: String
  }
}
</script>

<template>
    <div class="alert alert-primary">
        <p>{{ message }}</p>
    </div>
</template>
  
  
<style scoped>
.alert {
  color: #004085;
  background-color: #cce5ff;
  border: 2px solid #b8daff;
  border-radius: 5px;
  padding: 5px;

  text-align: center;
  bottom: 0;
  max-width: 400px;
  margin: 1rem auto;
}
</style>