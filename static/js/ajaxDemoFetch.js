 function updatePage() {
 fetch('/counter', {method :'get'}).
    then(res => res.json()).
    then(data => {console.log(data);
      document.getElementById("messageFromServer").innerHTML = data.message;
     }).
    catch(err => {
      console.log(err);
    });
}
setInterval(()=> this.updatePage(), 3000)
