import { Component, OnInit } from '@angular/core'
import { DungeonGeneratorService } from './dungeon-generator.service';
import { Dungeon } from './dungeon.model';

@Component({
    selector: 'dungeon-generator-grid',
    template: `
        <h3>Grid</h3>
        <pre>{{ dungeon | json }}</pre>
    `
})
export class DungeonGeneratorGridComponent implements OnInit {

    private dungeon: Dungeon | undefined;

    constructor(private dungeonGeneratorService: DungeonGeneratorService) { }

    ngOnInit() {
        this.dungeonGeneratorService.getGeneratedGrid()
        .subscribe(
            dungeon => this.dungeon = dungeon,
            error => alert(JSON.stringify(error))
        );
    }
}