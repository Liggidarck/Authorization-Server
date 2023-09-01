<template>
    <div class="login-page">
        <router-view/>
    </div>
</template>

<script>

export default {
    name: "sign-view"
}
</script>

<style lang="scss">
    .login-page {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        width: 100vw;
        background: linear-gradient(to bottom right, #ffffff 0%, #ffffff 100%);
    }
</style>