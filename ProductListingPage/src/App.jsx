import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Navbar from './components/Navbar';
import ProductList from './components/ProductList';

function App() {

  const [products, setProducts] = useState([
    { id: 1, name: "iPhone", category: "electronics", price: 90000 },
    { id: 2, name: "Laptop", category: "electronics", price: 70000 },
    { id: 3, name: "Rice Bag", category: "grocery", price: 1200 },
    { id: 4, name: "Cooking Oil", category: "grocery", price: 200 },
    { id: 5, name: "T-Shirts", category: "dresses", price: 200 }
  ]);

  const [cart, setCart] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("all");

  const categories = [...new Set(products.map(p => p.category))];

  const filterProducts =
    selectedCategory === "all"
      ? products
      : products.filter((p => p.category === selectedCategory));


  const toggleCart = (product) => {
    if (cart.find((item) => item.id === product.id)) {
      setCart(cart.filter((item) => item.id !== product.id));
    } else {
      setCart([...cart, product]);
    }
  };
  
  return (
    <>

    <Navbar
         setSelectedCategory={setSelectedCategory}
         selectedCategory={selectedCategory}
         categories={categories}
         cart={cart}
         toggleCart={toggleCart}
      />
      <ProductList products={filterProducts} cart={cart} toggleCart={toggleCart}></ProductList>
      
    </>
  )
}

export default App
