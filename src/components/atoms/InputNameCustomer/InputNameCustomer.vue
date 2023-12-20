<script setup>
import { ref } from "vue"

let nome = ref("");
</script>

<template>
    <div class="input-container">
        <label for="nome">Nome do cliente:</label>
        <input 
            type="text" 
            id="nome" 
            name="nome" 
            v-model="nome" 
            placeholder="Digite o seu nome">
    </div>
</template>

<style scoped>
@import url("../../../assets/main.css");
</style>