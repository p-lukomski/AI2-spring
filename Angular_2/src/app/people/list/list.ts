import {Component, OnInit} from '@angular/core';
import {Person} from '../../models/person';
import {PersonService} from '../../person';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-list',
  imports: [
    RouterLink
  ],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class ListComponent implements OnInit {
  people: Person[] = [];
  constructor(private personService: PersonService) {
  }

  ngOnInit(): void {
    this.loadData();
  }

  private loadData(): void {
    this.people = this.personService.getAll();
  }

  delete(index: number): void {
    this.personService.remove(index);
    this.loadData();
  }
}
