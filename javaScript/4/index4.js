//callback=a function that is passed as an argument to another function
// used to handle asynchronous operation:
/* 1.reading a file
   2.Network requests
   3.Interacting with Databases
   "hey when you're done, call this next."
*/ 
hello(goodbye);

function hello(callback){
    console.log("hello");
    callback();
}
function leave(){
    console.log("leave");
}
function goodbye(callback){
    console.log("goodbye");
    
}

sum(displaypage,10,5);

function sum(callback, x,y){
    let result=x+y;
    callback(result);

}
function display(result){
    console.log(result);
}

function displaypage(result){
    document.getElementById("myh1").textContent=result;

}

//forEach()=Methods used to iterate over the elements of an array and apply a specific function(callback) to each element
//array.forEach(callback);
// element, index, array are provided.

let numbers=[1,2,3,4,5];
numbers.forEach(double);
numbers.forEach(displaynum);
function double(element, index, array){
    array[index]=element*2;
}
function displaynum(element){
    console.log(element);
}

let fruits=["apple","banana","orange","coconut"];
fruits.forEach(displayf);
function displayf(element){
    console.log(element);
}

//.map()=accepts a callback and applies that function to each element to an array, then return a new array.

const numberss=[1,2,3,4,5];
const squares=numberss.map(square);
console.log(squares);
function square(element){
    return Math.pow(element,3);
}

// .filter()=creates a new array by filtering put elements;
let nnumber=[1,2,3,4,5,6,7,8,9,10];
let evenNums=nnumber.filter(iseven);
console.log(evenNums);
function iseven(element){
    return element%2===0;
}

//.reduce()=reduce the elements of an array to a single value.
const prices=[5,30,10,25,15,20];
const total=prices.reduce(sum);
console.log(`$${total.toFixed(2)}`);
function sum(accumulator, element){
    return accumulator+element;
}

const grade=[75,50,90,80,65,95];
const maximun=grade.reduce(getmax);
const minimun=grade.reduce(getmin);
console.log(maximun);
console.log(minimun);
function getmax(accumulator, element){
    return Math.max(accumulator,element);
}
function getmin(accumulator, element){
    return Math.min(accumulator,element);
}

//function expressions= a way to define functions as values or variables
setTimeout(function(){
    console.log("hello")
},3000);

const snumber=[1,2,3,4,5];
const asquares=snumber.map(function(element){
    return Math.pow(element,2);
});
console.log(asquares);

const cube=snumber.map(function(element){
    return Math.pow(element,3)});
console.log(cube);
const evenCube=snumber.filter(function(element){
    return element%2===0;
});
console.log(evenCube);