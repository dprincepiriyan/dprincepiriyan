//class
class Product{
    constructor(name, price){
        this.name=name;
        this.price=price;
    }
    displayProduct(){
        console.log(`Product:${this.name}`);
        console.log(`Price:${this.price}`);
    }
    calculateTotal(salesTax){
        return this.price+(this.price*salesTax);
    }
}
const salesTax=0.15;
const product1=new Product("shirt",1999);
product1.displayProduct();
const total=product1.calculateTotal(salesTax)
console.log(`total price with sales tax :${total}`);

//static

class mathUtil{
    static PI=3.142;
    static getdia(radius){
        return radius*2;
    }
    static getcir(radius){
        return 2*this.PI*radius;
    }
}
console.log(mathUtil.PI);
console.log(mathUtil.getdia(10));
console.log(mathUtil.getcir(10).toFixed(2));

class User{
    static userCount=0;
    constructor(username){
        this.username=username;
        User.userCount++;
    }
    sayHello(){
        console.log(`Hello, my name is ${this.username}`);
    }
    static getuseronline(){
        console.log(`There are ${this.userCount} users online`);
    }
}
const user1=new User("spongbob");
const user2=new User("patrick");
console.log(user1.username);
console.log(user2.username);
user1.sayHello();
user2.sayHello();
User.getuseronline();
