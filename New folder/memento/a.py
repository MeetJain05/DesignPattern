from graphviz import Digraph

def generate_uml():
    # Create a new directed graph
    dot = Digraph(comment='Cafe Order Management UML Diagram')

    # Add classes
    dot.node('Cafe', 'Cafe\n+ main(args: String[])')
    dot.node('CafeOrder', 'CafeOrder\n+ addItem(item: String)\n+ getOrderDetails(): String\n+ saveState(): OrderMemento\n+ restoreState(memento: OrderMemento)')
    dot.node('OrderMemento', 'OrderMemento\n+ OrderMemento(items: List<String>)\n+ getItems(): List<String>')
    dot.node('OrderHistory', 'OrderHistory\n+ OrderHistory(maxSize: int)\n+ save(memento: OrderMemento)\n+ undo(): OrderMemento')

    # Add relationships
    dot.edge('Cafe', 'CafeOrder', 'uses')
    dot.edge('CafeOrder', 'OrderMemento', 'creates')
    dot.edge('CafeOrder', 'OrderHistory', 'uses')
    dot.edge('OrderHistory', 'OrderMemento', 'manages')

    # Render the UML diagram
    return dot

uml_diagram = generate_uml()
uml_diagram.render('Cafe_Order_Management_UML', format='png', cleanup=True)
