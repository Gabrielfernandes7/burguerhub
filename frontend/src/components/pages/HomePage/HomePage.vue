<script setup>
import NavbarTemplate from 
  "../../templates/NavbarComponent/NavbarTemplate.vue"

import FooterComponent from
  "../../atoms/FooterComponent/FooterComponent.vue"

import BannerHome from 
  "@/components/atoms/BannerHome/BannerHome.vue";

import BurgerForm from 
  "@/components/molecules/BurgerForm/BurgerForm.vue"
</script>

<template>
  <NavbarTemplate>
    <main>
      <BannerHome />

      <BurgerForm />
    </main>
    <FooterComponent />
  </NavbarTemplate>
</template>
