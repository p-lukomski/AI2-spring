import { Component } from '@angular/core';
import {Person} from '../../models/person';
import {PersonService} from '../../person';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-add-person',
  imports: [FormsModule],
  templateUrl: './add-person.html',
  styleUrl: './add-person.css',
})
export class AddPersonComponent {
  person: Person = {
    address: {}
  };

  constructor(private personService: PersonService, private router: Router) {
  }

  save() : void {
    this.personService.add(this.person);
    this.router.navigate(['/']);
  }
}
