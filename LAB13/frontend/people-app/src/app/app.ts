import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {PersonComponent} from './person/person';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, PersonComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('people-app');
}
