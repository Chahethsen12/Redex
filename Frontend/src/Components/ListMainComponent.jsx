import React from 'react'

const ListMainComponent = () => {
  return (
    <div>
      <div class="container-main">

        <br />

        <h1 class="heading-main">Admin Page</h1>
        <br />
        <br />

        <div class="box-main-container-main">

          <div class="box-main">
              <h3>Vehicles</h3>
              <p>Clicking the button below, you can create, read, update and delete Vehicle information.</p>
              <a href="/vehicles" class="btn">click to visit</a>
          </div>

          <div class="box-main">
              <h3>Customers</h3>
            <p>Clicking the button below, you can create, read, update and delete Customer information.</p>
            <a href="/customers" class="btn">click to visit</a>
          </div>

          <div class="box-main">
              <h3>Rentals</h3>
            <p>Clicking the button below, you can create, read, update and delete Rental information.</p>
            <a href="/rentals" class="btn">click to visit</a>
          </div>

          <br />
          <br />
          

        </div>

      </div>
    </div>
  )
}

export default ListMainComponent