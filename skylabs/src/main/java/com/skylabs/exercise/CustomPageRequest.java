package com.skylabs.exercise;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CustomPageRequest extends PageRequest implements Pageable {

    public CustomPageRequest(int offset, int limit, Sort sort)
    {
        super(offset, limit, sort);
    }

}
