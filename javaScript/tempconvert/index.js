const textbox=document.getElementById("textbox");
const tofahrenheit=document.getElementById("tofahrenheit");
const tocelsius=document.getElementById("tocelsius");
const result=document.getElementById("result");
let x;
function convert(){
    if(tofahrenheit.checked){
        x=Number(textbox.value);
        let f=(x*1.8)+32;
        result.textContent=(`the value in fahrenheit is${f}`);
    }else if(tocelsius.checked){
        x=Number(textbox.value);
        let c=(x-32)/1.8;
        result.textContent=(`the value in celsius is ${c}`);
    }else{
        result.textContent=(`select a unit`);
    }
}
