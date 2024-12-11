import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { routes } from './app.routes';
import { AddVendorComponent } from './add-vendor/add-vendor.component';

const routes: Routes = [
  { path: 'add-vendor', component: AddVendorComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)], // Use the routes in RouterModule
  exports: [RouterModule]
})
export class AppRoutingModule {}
