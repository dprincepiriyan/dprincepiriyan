/*console.log(`hello nigga`);
window.alert(`this is an alert`);//pop up window
window.alert(`i like pizza!`);*/

//displaying data in index with the help of id.
//document.getElementById("myH1").textContent=`hello`;
//document.getElementById("myP").textContent='this is P';

/*variable declaration
 1.declaration let x;
 2.assignment x=100;
*/

/*let x;
x=100;
window.alert(`you are ${x} years old`);

let first="prince";
window.alert(`your name is ${first}`)
*/
//let online=true;

let full="prince piriyan";
let age=19;
let student=true;
document.getElementById("p1").textContent=`your name is ${full}`;
document.getElementById("p2").textContent=`your age is ${age}`;
document.getElementById("p3").textContent=`enrollment: ${student}`;

//how to accept user input.
//1.each way=window prompt
//2.professional way=html textbox

//1.

/*let username;
username=window.prompt("whats your username");
document.getElementById("myH1").textContent=`entered username ${username}`;
*/

//2.

/*let username;
document.getElementById("mysubmit").onclick=function(){
    username=document.getElementById("mytext").value;
    document.getElementById("myH1").textContent=`entered username ${username}`;
}
*/

//type conversion.
/*let page;
page=window.prompt(`how old are you`);
//before this conversion the age is a string not a int.
page=Number(page);
page+=1;
window.alert(page);*/

//const =a variable that cant be changed
//const can be only done for numbers and boolean value. it cant be done for strings and stuff.

/*const pi=3.14159
let radius;
let cir;
radius=window.prompt('enter the radius');
radius=Number(radius);
cir=2*pi*radius;
window.alert(`the circumferance of the circle is ${cir}`);
*/
const pi=3.14259;
let radius;
document.getElementById("radsub").onclick=function(){
    radius=document.getElementById("rad").value;
    let circ=2*pi*radius;
    document.getElementById("circum").textContent=`the circumferance of circle with radius ${radius} is ${circ}`
}