/*object=A collectioon of related properties and/or methods can represent
  real world objects(people, products, places)
  objects={key:value,function()}
*/

const person={
    fistName:"prince",
    lastName:"piriyan",
    age:30,
    isEmployed:false,
    sayHello: function(){console.log("hello my niggas")},
}

const person2={
    fistName:"suraj",
    lastName:"prakash",
    age:33,
    isEmployed:false,
    sayHello: function(){console.log("hello fuckass nigga")},
}
console.log(person.fistName);
console.log(person.lastName);
console.log(person.age);
console.log(person.isEmployed);
person.sayHello();
console.log(person2.fistName);
console.log(person2.lastName);
console.log(person2.age);
console.log(person2.isEmployed);
person2.sayHello();
