import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '@/components/pages/HomePage/HomePage.vue'
import OrdersPage from '@/components/pages/OrdersPage/OrdersPage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage
    },
    {
      path: '/pedidos',
      name: 'orders',
      component: OrdersPage
    }
  ]
})

export default router
