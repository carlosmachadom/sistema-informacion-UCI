package co.edu.unbosque.interfaces;

import java.util.List;

public interface ListInterface<M, DTO> {
    boolean add(DTO modelDTO);

    boolean put(DTO modelDTO);

    boolean clean(DTO modelDTO);

    List<M> all();

    M unique(DTO modelDTO);
}
