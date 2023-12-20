<template>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="">
            <img
                class="logo-burgerhub"
                src="/img/logo.png" 
                alt="logo do burger hub"
                height="40"
                width="40"
            >
        </a>

        <button class="navbar-toggler" type="button" 
            data-toggle="collapse" 
            data-target="#navbarCollapse" 
            aria-controls="navbarCollapse" 
            aria-expanded="false" 
            aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <RouterLink class="nav-link" 
                to="/">
                    Home
              </RouterLink>
            </li>

            <li class="nav-item">
              <RouterLink to="/pedidos" class="nav-link">Pedidos</RouterLink>
            </li>
          </ul>
        </div>
      </nav>
    <slot></slot>
</template>

<style scoped>
.logo-burgerhub {
    padding: 4px;
}

a {
    text-decoration: none;
    color: #fcba03;
    margin: 12px;
    transition: .2;
}
</style>