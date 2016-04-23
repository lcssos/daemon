package cn.martin.es.service;

import cn.martin.es.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lcssos on 16/4/23.
 */
@Service
public class BookService {
    @Resource
    private BookRepository bookRepository;


}
