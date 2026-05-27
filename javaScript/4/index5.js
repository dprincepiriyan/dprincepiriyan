// arrow function= a concise way to write function expressions good for simple functions that you use only once (parameter)=> some code
/*const hello=(name,age)=>{console.log(`hello ${name}`)
                         console.log(`you are ${age} old`)};
hello("prince",20);

setTimeout(()=>console.log("hello"),3000);
*/
//this=reference to the object where THIS is used
//(the object depends on the immediate context person.name=this.name)

const person1={
    name:"spongebob",
    favfood:"burger",
    sayHello:function(){console.log(`Hi! i am ${this.name}`)}
}
person1.sayHello();