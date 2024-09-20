<template>
    <p>Banner</p>
    <div class="banner-container">
        <h1>Monte seu Hamburger</h1>
    </div>
</template>

<style scoped>
.banner-container {
    background-image: url('/img/burger.jpg');
    background-color: #222;
    background-position: 0 -450px;
    background-size: auto;
    background-repeat: no-repeat;

    height: 35vh;
    display: flex;
    align-items: center;
    justify-content: flex-start;
}

.banner-container h1 {
    margin: 0 auto;
    padding-right: 20px;
    color: #FFF;
    text-align: center;
    font-size: 40px;
    background-color: #222;
    padding: 15px 35px;
}
</style>