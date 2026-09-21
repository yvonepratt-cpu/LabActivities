<?php
class Book{
	private $title;
	private $author;
	private $status = "Available";

	function setDetails($t, $a){
		$this->title = $t;
		$this->author = $a;
	}

	function borrowBook(){
		$this->status = "Borrowed";
	}

	function returnBook(){
		$this->status = "Returned";
	}

	function getDetails(){
		echo "<h3>Book Details</h3>";
		echo "Title: ".$this->title."<br>";
		echo "Author: ".$this->author."<br>";
		echo "Status: ".$this->status."<br>";
	}
}
?>

<html>
<head>
	<title>Book Activity</title>
</head>
<body>

<h3>Enter Book Information</h3>
<form method="post">
	Book Title: <input type="text" name="txtTitle"><br><br>
	Author Name: <input type="text" name="txtAuthor"><br><br>
	<input type="submit" name="btnBorrow" value="Borrow Book">
	<input type="submit" name="btnReturn" value="Return Book">
</form>

<?php
if(isset($_POST['btnBorrow']) || isset($_POST['btnReturn'])){
	$b = new Book();
	$b->setDetails($_POST['txtTitle'], $_POST['txtAuthor']);

	if(isset($_POST['btnBorrow'])){
		$b->borrowBook();
	}else if(isset($_POST['btnReturn'])){
		$b->returnBook();
	}

	$b->getDetails();
}
?>

</body>
</html>