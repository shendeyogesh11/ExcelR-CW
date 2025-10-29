import React from 'react'

const ProductList = ({ products, cart, toggleCart }) => {
  return (
   <div className="products">
      {products.length === 0 ? (
        <p>No products found</p>
      ) : (
        products.map((p) => {
          const inCart = cart.find((item) => item.id === p.id);
          return (
            <div key={p.id} className="product-card">
              <h3>{p.name}</h3>
              <p>Category: {p.category}</p>
              <p><strong>Price: ₹{p.price}</strong></p>
              <button
                className={inCart ? "remove" : "add"}
                onClick={() => toggleCart(p)}
              >
                {inCart ? "Remove" : "Add to Cart"}
              </button>
            </div>
          );
        })
      )}
    </div>
  )
}

export default ProductList
