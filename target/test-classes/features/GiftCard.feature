Feature: Purchase Gift Cards from Demo Web Shop Online store

        Scenario Outline: Purchase Giftcard and Validate the product Ordered.

            Given Launch the Demo Webshop Application
             When Enter the Username <Username>, password <Password> and validate
              And Click on the <Categories> and select the product <product>
              And Enter the user <RecpName> and <RecpEmail> details and click Add To Cart
              And Click on shippingcart link
              And Verify the product <product> price
              And Click on the terms and condition and Checkout
              And Enter or chose the billing address
              And Select the mode <mode> of payment
              And Check the payment information
              And Verify the product price and click on confirm button
             Then Captured the order number generated

        Examples:
                  | Username     | Password | Categories | product                 | RecpName      | RecpEmail              | mode       |
                  | boy@mail.com | Boy1234  | Gift Cards | $5 Virtual Gift Card    | fivedollar    | fivedollar@mail.com    | COD        |
                  | boy@mail.com | Boy123   | Gift Cards | $100 Physical Gift Card | hundreddollar | hundreddollar@mail.com | COD        |
                  | boy@mail.com | Boy123   | Gift Cards | $25 Virtual Gift Card   | twofivedollar | Twofivedollar@mail.com | MoneyOrder |
                  | boy@mail.com | Boy123   | Gift Cards | $50 Physical Gift Card  | fiftydollar   | fiftydollar@mail.com   | CreditCard |
        		