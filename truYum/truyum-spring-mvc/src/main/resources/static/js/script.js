/*eslint-env browser*/
var adminMenuItems =
[{id:0,name : "Sandwich", price : "Rs. 99.00", active : "Yes", dateOfLaunch : "15/03/2017", category : "Main Course", freeDelivery : "Yes",},
{id:1,name : "Burger", price : "Rs. 129.00", active : "Yes", dateOfLaunch : "23/12/2017", category : "Main Course", freeDelivery : "No",},
{id:2,name : "Pizza", price : "Rs. 149.00", active : "Yes", dateOfLaunch : "21/08/2017", category : "Main Course", freeDelivery : "No",},
{id:3,name : "French Fries", price : "Rs. 57.00", active : "Yes", dateOfLaunch : "02/07/2017", category : "Starters", freeDelivery : "Yes",},
{id:4,name : "Chocolate Brownie", price : "Rs. 32.00" , active : "Yes", dateOfLaunch : "02/11/2022", category : "Dessert", freeDelivery : "Yes",}];
function createAdminMenuList(){
    var editedStr = localStorage.getItem("edited");
    if(editedStr!=undefined)
        {
            var editedObj = JSON.parse(editedStr);
            adminMenuItems[editedObj['id']]=editedObj;
        }
        var arrayString=JSON.stringify(adminMenuItems);
        localStorage.setItem('editedArray',arrayString);
        var tableBody = document.getElementsByTagName("tbody")[0];
        for(var i=0;i<adminMenuItems.length;i++){
        var row = document.createElement("tr");
        
            for(var j in adminMenuItems[i])
                {
                    if(j=='id')
                        continue;
                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(adminMenuItems[i][j]);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    if(j=="name")
                        {
                            cell.setAttribute("class","first-column");
                        }
                    else if(j=="price")
                        {
                            cell.setAttribute("class","price-column");
                        }
                    
                }
            var cell = document.createElement("td");
            var a = document.createElement("a");
            a.setAttribute("href","/edit-menu-item.html");
            a.innerHTML="Edit";
            a.setAttribute("id",i.toString());
            a.setAttribute("onclick","localStorage.setItem('id',this.id)");
            cell.appendChild(a);
            row.appendChild(cell);
            tableBody.appendChild(row);
        }

    }
function editOnLoad()
{
    var id=localStorage.getItem("id");
    var editedArrayString=localStorage.getItem("editedArray");
    var editedArray = JSON.parse(editedArrayString);
    var name = document.getElementsByName("title")[0];
    var price = document.getElementsByName("price")[0];
    var dateOfLaunch = document.getElementsByName("dateOfLaunch")[0];
    var category = document.getElementsByName("category")[0];
    var freeDelivery = document.getElementsByName("freeDelivery")[0];
    name.value = editedArray[parseInt(id)]['name'];
    price.value = editedArray[parseInt(id)]['price'].slice(4);
    dateOfLaunch.value = editedArray[parseInt(id)]['dateOfLaunch'];
    category.value = editedArray[parseInt(id)]['category'];
    if(editedArray[parseInt(id)]['active']=="Yes"){
        document.getElementById("activeYes").checked=true;
    }
    else
        {
            document.getElementById("activeNo").checked=true;
        }
    if(editedArray[parseInt(id)]['freeDelivery']=="Yes")
        {
            freeDelivery.checked=true;
        }
}
function addItemAdmin(){
    var name = document.getElementsByName("title")[0].value;
    var price = "Rs. "+document.getElementsByName("price")[0].value;
    var active =document.getElementsByName("inStock")[0].value;
    var dateOfLaunch = document.getElementsByName("dateOfLaunch")[0].value;
    var category = document.getElementsByName("category")[0].value;
    var freeDelivery = document.getElementsByName("freeDelivery")[0].checked?"Yes":"No";
    var id=localStorage.getItem("id");
    var myJson = JSON.stringify({id:parseInt(id),name:name,price:price,active:active,dateOfLaunch:dateOfLaunch,category:category,freeDelivery:freeDelivery});
    localStorage.setItem('edited',myJson);
}
function createCustomerMenuList(){
        var id=localStorage.getItem("id");
        var editedArrayString=localStorage.getItem("editedArray");
        if(editedArrayString==undefined)
        {
        var arrayString=JSON.stringify(adminMenuItems);
        localStorage.setItem('editedArray',arrayString);
        var editedArrayString=localStorage.getItem("editedArray");
        }
        var editedArray = JSON.parse(editedArrayString);

        var tableBody = document.getElementsByTagName("tbody")[0];
        for(var i=0;i<editedArray.length;i++){
        var row = document.createElement("tr");
        
            for(var j in editedArray[i])
                {
                    if(j=='name')
                {
                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(editedArray[i][j]);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    if(j=="name")
                    cell.setAttribute("class","first-column");
                        
                    
                }
                }
            for(var j in editedArray[i])
                {
                    if(j=='freeDelivery')
                {
                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(editedArray[i][j]);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
                    
                }
                }
                        for(var j in editedArray[i])
                {
                    if(j=='price')
                {
                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(editedArray[i][j]);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    cell.setAttribute("class","price-column");
                        
                    
                }
                }
                        for(var j in editedArray[i])
                {
                    if(j=='category')
                {
                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(editedArray[i][j]);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
                }
                }
            var cell = document.createElement("td");
            var a = document.createElement("a");
            a.setAttribute("href","/menu-item-list-customer-notification.html");
            a.innerHTML="Add To Cart";
            a.setAttribute("id",i.toString());
            a.setAttribute("onclick","addToCart(\''+this.id+'\'\)");
            cell.appendChild(a);
            row.appendChild(cell);
            tableBody.appendChild(row);
        }

    }



function addToCart(id)
{   var cart=[];
    localStorage.setItem('id',id);
    var storageArrayString = localStorage.getItem('editedArray');
    var storageArray = JSON.parse(storageArrayString);
    var cartString = localStorage.getItem('cart')
    if(cartString!=undefined){
        cart = JSON.parse(cartString);
    }
    cart.push(storageArray[parseInt(id)]);
    var newCartString = JSON.stringify(cart);
    localStorage.setItem('cart',newCartString);
    
}

function displayCart()
{
    var myCartString = localStorage.getItem('cart');
    if(myCartString==undefined)
        {    window.location.href="cart-empty.html";
        }
    else{
        var myCart = JSON.parse(myCartString);
        
var tableBody = document.getElementsByTagName("tbody")[0];
var total = 0.00;
        for(var i=0;i<myCart.length;i++){
        var row = document.createElement("tr");
        
            for(var j in myCart[i])
                {
                    if(j=='name')
                {
                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(myCart[i][j]);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    if(j=="name")
                    cell.setAttribute("class","first-column");
                        
                    
                }
                }
            for(var j in myCart[i])
                {
                    if(j=='freeDelivery')
                {
                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(myCart[i][j]);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
                    
                }
                }
                        for(var j in myCart[i])
                {
                    if(j=='price')
                {
                    var cell = document.createElement("td");
                    var cellText = document.createTextNode(myCart[i][j]);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    cell.setAttribute("class","price-column");
                        
                    total+=parseFloat(myCart[i][j].slice(4));
                }
                }
            var cell = document.createElement("td");
            var a = document.createElement("a");
            a.setAttribute("href","#");
            a.innerHTML="Delete";
            a.setAttribute("id",i.toString());
            a.setAttribute("onclick","deleteFromCart(\''+this.id+'\'\)");
            cell.appendChild(a);
            row.appendChild(cell);
            tableBody.appendChild(row);
        }
        total=total.toFixed(2);
    document.getElementById("total").innerHTML="Rs. "+total;
 
    }
}
function deleteFromCart(id){
            console.log(id);
    var oldCartString = localStorage.getItem('cart');
    var oldCart = JSON.parse(oldCartString);
    oldCart.splice(id,1);
    if(oldCart.length==0)
    {window.location.href="cart-empty.html";
    localStorage.removeItem('cart');
    }
    else {
    var newCartString = JSON.stringify(oldCart);
    localStorage.setItem('cart',newCartString);
    window.location.href="cart-notification.html";
    }
    
}