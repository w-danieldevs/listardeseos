import { TestBed } from '@angular/core/testing';

import { ListaItems } from './lista-items';

describe('ListaItems', () => {
  let service: ListaItems;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaItems);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
