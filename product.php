<?php
class Product{
	private $name;
	private $price;
	private $qty;

	function setDetails($n, $p, $q){
		$this->name = $n;
		$this->price = $p;
		$this->qty = $q;
	}

	function calculateTotal(){
		return $this->price * $this->qty;
	}

	function showProduct(){
		echo "<h3>Product Info</h3>";
		echo "Product Name: ".$this->name."<br>";
		echo "Price: ".$this->price."<br>";
		echo "Quantity: ".$this->qty."<br>";
		echo "Total Cost: ".$this->calculateTotal();
	}
}
?>

<html>
<head>
	<title>Product Inventory</title>
</head>
<body>

<h3>Enter Product Details</h3>
<form method="post">
	Product Name: <input type="text" name="txtName"><br><br>
	Price: <input type="text" name="txtPrice"><br><br>
	Quantity: <input type="text" name="txtQty"><br><br>
	<input type="submit" name="btnSubmit" value="Submit">
</form>

<?php
if(isset($_POST['btnSubmit'])){
	$p = new Product();
	$p->setDetails($_POST['txtName'], $_POST['txtPrice'], $_POST['txtQty']);
	$p->showProduct();
}
?>

</body>
</html>