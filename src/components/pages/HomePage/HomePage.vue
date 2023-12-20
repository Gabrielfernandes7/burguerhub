<script setup>
import NavbarTemplate from 
  "../../templates/NavbarComponent/NavbarTemplate.vue"

import FooterComponent from
  "../../atoms/FooterComponent/FooterComponent.vue"
import BannerHome from "@/components/atoms/BannerHome/BannerHome.vue";

</script>

<template>
  <NavbarTemplate>
    <main>
      <BannerHome />
    </main>
    <FooterComponent />
  </NavbarTemplate>
</template>
