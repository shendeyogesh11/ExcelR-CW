import React, { useState } from 'react'

const Navbar = ({ setSelectedCategory, categories, cart, toggleCart}) => {

    const [showCart, setShowCart] = useState(false);

  return (
    <nav>
      <div>
        <button onClick={() => setSelectedCategory("all")}>All</button>
        {categories.map((cat) => (
          <button key={cat} onClick={() => setSelectedCategory(cat)}>
            {cat}
          </button>
        ))}
      </div>

      <div className="cart-container">
        <button className="cart-button" onClick={() => setShowCart(!showCart)}>
          🛒 Cart ({cart.length})
        </button>

        {showCart && (
          <div className="cart-dropdown">
            {cart.length === 0 ? (
              <p style={{ textAlign: 'center', margin: '8px 0' }}>Cart is empty</p>
            ) : (
              cart.map((item) => (
                <div key={item.id} className="cart-item">
                  <span>{item.name}</span>
                  <button onClick={() => toggleCart(item)}>x</button>
                </div>
              ))
            )}
          </div>
        )}
      </div>
    </nav>
  )
}

export default Navbar
