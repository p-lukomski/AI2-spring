import { Component } from '@angular/core';

@Component({
  selector: 'app-list',
  imports: [],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List {
  items: string[] = [];

  addItem(value: string) {
    const trimmed = value.trim();
    if (trimmed.length === 0) return;
    this.items.push(trimmed);
  }

  removeItem(index: number) {
    this.items.splice(index, 1);
  }
}
