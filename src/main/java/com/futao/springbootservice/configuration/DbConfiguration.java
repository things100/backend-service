package com.futao.springbootservice.configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.futao.starter.fustack.exceptions.LogicException;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author futao
 * @date 2020/11/2
 */
@Slf4j
@Configuration
public class DbConfiguration {
    @Bean
    public Interceptor mybatisPlusInterceptor() {
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInnerInterceptor.setOverflow(false);
        paginationInnerInterceptor.setMaxLimit(100L);
        paginationInnerInterceptor.setDbType(DbType.MYSQL);

        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);


        // sql阻断。防止全表更新/删除 检测update/delete的where条件是否一定是true
        BlockAttackInnerInterceptor blockAttackInnerInterceptor = new BlockAttackInnerInterceptor() {
            @Override
            protected void processDelete(Delete delete, int index, Object obj) {
                // super.processDelete(delete, index, obj);
                boolean isDanger = isDanger(delete.getWhere());
                if (isDanger) {
                    log.warn("检测到危险DELETE-SQL!");
                    Assert.isFalse(isDanger, "危险UPDATE-SQL操作");
                }
            }

            @Override
            protected void processUpdate(Update update, int index, Object obj) {
                // super.processUpdate(update, index, obj);
                boolean isDanger = isDanger(update.getWhere());
                if (isDanger) {
                    log.warn("检测到危险UPDATE-SQL!");
                    Assert.isFalse(isDanger, "危险UPDATE-SQL操作");
                }
            }
        };
        mybatisPlusInterceptor.addInnerInterceptor(blockAttackInnerInterceptor);

        return mybatisPlusInterceptor;
    }

    /**
     * 检查是否是危险的WHERE条件
     *
     * @param where
     */
    private boolean isDanger(Expression where) {
        if (where == null) {
            return true;
        }
        if (where instanceof EqualsTo) {
            // example: 1=1
            EqualsTo equalsTo = (EqualsTo) where;
            Expression leftExpression = equalsTo.getLeftExpression();
            Expression rightExpression = equalsTo.getRightExpression();
            return leftExpression.toString().equals(rightExpression.toString());
        } else if (where instanceof NotEqualsTo) {
            // example: 1 != 2
            NotEqualsTo notEqualsTo = (NotEqualsTo) where;
            Expression leftExpression = notEqualsTo.getLeftExpression();
            Expression rightExpression = notEqualsTo.getRightExpression();
            return !leftExpression.toString().equals(rightExpression.toString());
        }
        return false;
    }
}
