<script lang="ts" setup>
import NavbarTemplate from 
  "../../templates/NavbarComponent/NavbarTemplate.vue";

import FooterComponent from
  "../../atoms/FooterComponent/FooterComponent.vue";

import BannerHome from 
  "../../atoms/BannerHome/BannerHome.vue";

import BurgerForm from 
  "../../molecules/BurgerForm/BurgerForm.vue";
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
