let fruits=["apple","orange","banana"];
fruits[0]="coconut";
fruits.push="apple";
//fruits.unshift("mango"); add the element in the start;
//fruits.shift(); removes from the starting

let nums=fruits.length;
console.log(nums);

//for(let fruit of fruits) is used as an advanced version of for loop.

// spread operator= ... allows an iterable such as an array or string to be expanded into seperate elements(unpacks the elements).

let numbers=[1,2,3,4,5];
let maxi=Math.max(...numbers);
let mini=Math.min(...numbers);

let username="prince";
let letters=[...username];
window.alert(letters);

//rest perameters: basically the *args of java script, used to take in multiple different arguments.

function openfridge(...foods){
    window.alert(foods);
}
const food1='pizza';
const food2='burger';
const food3='hotdog';
const food4='sushi';
openfridge(food1, food2, food3, food4);

function sum(...numbers){
    let result=0;
    for(let number of numbers){
        result+=number;
    }
    return result;
}

const total=sum(1,2,3,4,5,6,7,8,9,10);
window.alert(total);