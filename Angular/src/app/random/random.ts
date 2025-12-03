import {Component, Input} from '@angular/core';
import { RandomService } from '../random-service';
import {NgClass} from '@angular/common';


@Component({
  selector: 'app-random',
  imports: [
    NgClass
  ],
  templateUrl: './random.html',
  styleUrl: './random.css',
})
export class Random {

  @Input() max: number = 10;

  generated: number | null = null;
  comment: string = "";

  constructor(private randomService: RandomService) {}
  generate(max: number) {
    this.generated = this.randomService.getRandom(max);
    if(this.generated <= this.max * 0.5) this.comment = "Dolna połowa"; else this.comment = "Górna połowa";
  }

  isLow(): boolean {
    return this.generated !== null && this.generated <= this.max * 0.5;
  }
}
