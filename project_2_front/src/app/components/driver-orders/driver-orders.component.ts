import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { OrderStatus } from 'src/app/models/order-status';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-driver-orders',
  templateUrl: './driver-orders.component.html',
  styleUrls: ['./driver-orders.component.css'],
})
export class DriverOrdersComponent implements OnInit {
  selectedOrder?: Order;

  ngOnInit(): void {
    this.getOrders();
  }

  public activeOrder?: Order;

  public readyOrders: Order[] = [];
  public activeOrders: Order[] = [];

  public hasActiveOrder = false;

  constructor(private os: OrdersService) {}

  getOrders() {
    this.os.getOrdersByStatus(2).subscribe(
      (data) => {
        this.readyOrders = data.body as Order[];
        console.log('data: ' + data.body);
      },
      (error) => {
        console.log(error);
      }
    );

    this.os.getOrdersByStatus(3).subscribe(
      (data) => {
        this.activeOrders = data.body as Order[];
      },
      (error) => {
        console.log(error);
      }
    );
  }

  takeOrder(order: Order) {
    let orderStatus: OrderStatus;
    this.activeOrder = order;
    this.hasActiveOrder = true;

    // I want to change the order status of a specific order ID
    // order.orderId
  }
}
