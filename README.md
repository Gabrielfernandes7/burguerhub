# Burguer Hub

Este projeto foi desenvolvido com Vue 3 no Vite.

Trata-se de um projeto desenvolvido com finalidade de ser um sistema
de agendamento de pedidos de hamburgers onde o cliente poderá solicitar o hamburger
e saber em que estágio se encontra o hamburger. 

No final, a aplicação irá emitir uma
comanda de quantos hamburgeres foi consumido pelo cliente em questão.

## Costumizar configurações do projeto

Veja [Vite Configuration Reference](https://vitejs.dev/config/).

## Project Setup

```sh
npm install
```

### Compile and Hot-Reload for Development

```sh
npm run dev
```

### Compile and Minify for Production

```sh
npm run build
```

### Run Unit Tests with [Vitest](https://vitest.dev/)

```sh
npm run test:unit
```

### Run End-to-End Tests with [Cypress](https://www.cypress.io/)

```sh
npm run test:e2e:dev
```

This runs the end-to-end tests against the Vite development server.
It is much faster than the production build.

But it's still recommended to test the production build with `test:e2e` before deploying (e.g. in CI environments):

```sh
npm run build
npm run test:e2e
```

### Lint with [ESLint](https://eslint.org/)

```sh
npm run lint
```
