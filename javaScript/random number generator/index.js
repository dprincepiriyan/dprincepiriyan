//Math =built-in object that provides a collection of properties and methods.
//Math.round(x);
//Math.floor(x);
//Math.ceil(x);
//Math.trunc(x);
//Math.pow(x,y);
//Math.sqrt(x);
//Math.sin(x);
//Math.cos(x);
//Math.tan(x);
//Math.abs(x);
//Math.sign(x);
/*let min=50;
let max=100;
let random=Math.floor(Math.random()*(max-min))+min;
window.alert(random);*/
const mybutton=document.getElementById("mybutton");
const label=document.getElementById("mylabel");
let x;
mybutton.onclick=function(){
    x=Math.floor(Math.random()*6)+1;
    label.textContent=x;
}


