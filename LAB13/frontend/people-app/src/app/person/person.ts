import { Component } from '@angular/core';
import {PersonService} from '../person-service';
import {Person} from '../models/person';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-person',
  imports: [
    FormsModule, CommonModule
  ],
  templateUrl: './person.html',
  styleUrl: './person.css',
})
export class PersonComponent {
  people: Person[] = [];
  formPerson: Person = this.getEmptyPerson();
  isEditMode = false;
  errorMessage: string | null = null;
  successMessage: string | null = null;

  constructor(private personService: PersonService) {
    this.loadPeople();
  }

  private getEmptyPerson(): Person {
    return {
      firstName: '',
      familyName: '',
      email: '',
      age: null
    };
  }

  loadPeople(): void {
    this.errorMessage = null;
    this.personService.getPeople().subscribe({
      next: (data) => {
        console.log('API getPeople() ->', data);
        this.people = data;
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Błąd przy pobieraniu danych';
      }
    });
  }

  startCreate(): void {
    this.isEditMode = false;
    this.formPerson = this.getEmptyPerson();
  }

  startEdit(person: Person): void {
    this.isEditMode = true;
    this.formPerson = { ...person };
  }

  save(): void {
    if (this.isEditMode && this.formPerson.id != null) {
      this.personService.updatePerson(this.formPerson.id, this.formPerson).subscribe({
        next: () => {
          this.successMessage = 'Zaktualizowano osobę';
          this.loadPeople();
          this.startCreate();
        },
        error: (err) => console.error(err)
      });
    } else {
      this.personService.createPerson(this.formPerson).subscribe({
        next: () => {
          this.successMessage = 'Dodano osobę';
          this.loadPeople();
          this.startCreate();
        },
        error: (err) => console.error(err)
      });
    }
  }

  delete(p: Person): void {
    if (!p.id) return;
    this.personService.deletePerson(p.id).subscribe({
      next: () => {
        this.successMessage = 'Usunięto osobę';
        this.loadPeople();
      },
      error: (err) => console.error(err)
    });
  }

}
