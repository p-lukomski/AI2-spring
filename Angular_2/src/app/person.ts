import { Injectable } from '@angular/core';
import {Person} from './models/person';

@Injectable({
  providedIn: 'root',
})
export class PersonService {
  private readonly STORAGE_KEY = 'people';
  constructor() {}

  private loadAllInternal(): Person[] {
    const raw = localStorage.getItem(this.STORAGE_KEY);
    if (!raw) return [];

    try {
      const data = JSON.parse(raw) as Person[];
      return Array.isArray(data) ? data : [];
    } catch (e) {
      console.error('Error: ', e);
      return [];
    }
  }

  private saveAllInternal(people: Person[]): void {
    localStorage.setItem(this.STORAGE_KEY, JSON.stringify(people));
  }

  getAll(): Person[] {
    return this.loadAllInternal();
  }

  getByIndex(index: number): Person | undefined {
    const people = this.loadAllInternal();
    return people[index];
  }

  add(person: Person): void {
    const people = this.loadAllInternal();
    people.push(person);
    this.saveAllInternal(people);
  }

  remove(index: number): void {
    const people = this.loadAllInternal();
    if (index < 0 || index >= people.length) {
      console.warn('Próba usunięcia osoby o nieprawidłowym indeksie:', index);
      return;
    }
    people.splice(index, 1);
    this.saveAllInternal(people);
  }
}
