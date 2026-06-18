import { TestBed } from '@angular/core/testing';

import { ProductoModel } from './producto-model';

describe('ProductoModel', () => {
  let service: ProductoModel;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductoModel);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
