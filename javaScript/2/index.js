let age;
const mytext=document.getElementById("mytext");
const button=document.getElementById("mybutton");
const myp=document.getElementById("myp");
button.onclick=function(){
    age=mytext.value;
    age=Number(age);
    if(age>=18){
        myp.textContent=(`you are old enough`);
    }else if(age<18){
        myp.textContent=(`you are not old enough bitch`);
    }
}
