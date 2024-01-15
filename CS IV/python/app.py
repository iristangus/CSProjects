from flask import Flask, render_template, request
app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html.j2')

@app.route('/delivery', methods=['POST'])
def delivery():
    customerName = request.values.get("yourName")
    if len(customerName) == 0:
        return render_template("error.html.j2")
    deliveryMethod = request.values.get("deliveryOptions")
    isDelivery = False
    if deliveryMethod == 'delivery':
        isDelivery = True
        return render_template('address.html.j2', customerName = customerName, isDelivery = isDelivery)
    else:
        return render_template('location.html.j2', customerName = customerName, isDelivery = isDelivery)

@app.route('/order', methods=['POST'])
def order():
    isDelivery = eval(request.values.get("isDelivery"))

    if isDelivery == True:
        addressLine1 = request.values.get("addressLine1")
        apartment = request.values.get("apartment")
        city = request.values.get("city")
        state = request.values.get("state")
        zipCode = request.values.get("zip")

        if len(addressLine1) == 0 or len(city) == 0 or len(zipCode) == 0:
            return render_template("error.html.j2")

        delivery = "Your order has been sent to:\n" + formatAddress(addressLine1, apartment, city, state, zipCode)
    else:
        delivery = "Pick your order up at our location in " + request.values.get("action")
    
    customerName = request.values.get("yourName")
    
    return render_template('order.html.j2', customerName = customerName, delivery = delivery)

@app.route('/receipt', methods=['POST'])
def receipt():
    customerName = request.values.get("yourName")

    latteAmount = int(request.values.get("latteRange"))
    sandwichAmount = int(request.values.get("breakfastSandwichRange"))
    macaronAmount = int(request.values.get("macaronRange"))
    cakeAmount = int(request.values.get("crepeCakeRange"))

    if latteAmount > 10 or sandwichAmount > 10 or macaronAmount > 10 or cakeAmount > 10:
        return render_template("error.html.j2")

    customerTotal = calculateTotal(latteAmount, sandwichAmount, macaronAmount, cakeAmount)

    delivery = request.values.get("delivery")

    return render_template('receipt.html.j2', customerName = customerName, customerTotal = customerTotal, 
                            delivery = delivery, latteAmount = latteAmount, sandwichAmount = sandwichAmount,
                            macaronAmount = macaronAmount, cakeAmount = cakeAmount)

def formatAddress(addressLine1, apartment, city, state, zipCode):
    address = addressLine1
    if apartment != None:
        address += apartment
    address = address + ", " + city + " " + state + " " + zipCode
    return address

def calculateTotal(latteAmount, sandwichAmount, macaronAmount, cakeAmount):
    total = 0
    total += latteAmount * 2.50
    total += sandwichAmount * 6.00
    total += macaronAmount * 5.00
    total += cakeAmount * 7.50
    total = str(round(total, 2))
    return total
   
