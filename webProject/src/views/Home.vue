<template>
  <div class="home">
    {{ text }}
  </div>
</template>

<script>
// @ is an alias to /src
import axios from "axios";

export default {
  name: "home",
  components: {},
  data() {
    return {
      text: ""
    };
  },
  mounted() {
    axios
      .post("/demo2/login", {
        username: "superbaby",
        password: "12345"
      })
      .then(res => {
        this.text = JSON.stringify(res);
      });
  }
};
</script>
