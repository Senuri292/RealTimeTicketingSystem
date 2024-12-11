import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { routes } from './app.routes';
import { AddVendorComponent } from './add-vendor/add-vendor.component';
import {AddCustomerComponent} from './add-customer/add-customer.component';

const routes: Routes = [
  { path: 'vendor', component: AddVendorComponent },
  { path: 'customer', component: AddCustomerComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)], // Use the routes in RouterModule
  exports: [RouterModule]
})
export class AppRoutingModule {}
