//method chaining
//no method chaining_____________________________
/*let username=window.prompt("enter username");
username=username.trim();
let letter=username.charAt(0);
letter=letter.toUpperCase();
let extra=username.slice(1);
extra=extra.toLowerCase();
window.alert(letter+extra);
*/
//method chanining__________________________________
let username=window.prompt("enter username");
username=username.trim().charAt(0).toUpperCase()+ username.trim().slice(1).toLowerCase();
window.alert(username);

