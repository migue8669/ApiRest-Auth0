import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";;
import { VueloComponent } from "./pages/vuelo/vuelo.component";
import { VueloListComponent } from './pages/vuelo/vuelo-list/vuelo-list.component';

const routes: Routes = [
  { path: "", redirectTo: "/vuelo", pathMatch: "full" },
  {
    path: "vuelo",
    component: VueloComponent
  },
];
  /*{
    path: "sofkianos",
    canActivate: [AuthGuardService],
    component: SofkianosListComponent
  },
  {
    path: "addsofkiano",
    canActivate: [AuthGuardService],
    component: SofkianosListComponent
  },
  {
    path: 'sofkiano/create',
    canActivate: [AuthGuardService], component: SofkianoCreateComponent
  },
  {
    path: 'createclients',
    canActivate: [AuthGuardService], component: ClientContactInfoComponent
  },

  {
    path: 'clientsdetails',
    canActivate: [AuthGuardService], component: ClientDetailComponent
  },
  {
    path:'listclients',
    canActivate: [AuthGuardService], component: ClientListComponent
  },
  {
    path:'clientdetails/:id', canActivate:[AuthGuardService], component: ClientDetailComponent
  }
,
  {
    path: 'hoursofkiano', canActivate: [AuthGuardService], component: HoursSofkianoComponent
  }
  // { path: 'login', component: LoginComponent },
  /*{
    path: 'addclient/:id',
    canActivate: [AuthGuardService], component: AddClientToProjectComponent
  },
  {
    path: 'projectdetails',
    canActivate: [AuthGuardService], component: ProjectdetailsComponent
  },
  {
    path: 'home',
    canActivate: [AuthGuardService], component: LandingPageComponent
  },
  {
    path: '',
    canActivate: [AuthGuardService], component: LandingPageComponent
  },
  {
    path: 'projectcrud',
    canActivate: [AuthGuardService], component: ProjectCRUDComponent
  },
  {
    path: 'clients',
    canActivate: [AuthGuardService], component: ClientsComponent
  },
  {
    path: 'clientsdetails',
    canActivate: [AuthGuardService], component: ClientsdetailsComponent
  },*/
  /*{
    path: '**',
    canActivate: [AuthGuardService], redirectTo: 'home', pathMatch: 'full'
  }*/


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
