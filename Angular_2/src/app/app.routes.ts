import { Routes } from '@angular/router';
import {ListComponent} from './people/list/list';
import {DetailsComponent} from './people/details/details';
import {AddPersonComponent} from './people/add-person/add-person';
import {NotFoundComponent} from './not-found/not-found';


export const routes: Routes = [
  {path: '', component: ListComponent},
  {path: 'details/:id', component: DetailsComponent},
  {path: 'add', component: AddPersonComponent},
  {path: '**', component: NotFoundComponent}
];
