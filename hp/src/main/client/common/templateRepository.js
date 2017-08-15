/**
 * Created by sanasov on 20.02.2017.
 *
 * класс содержащий данные о всех шаблонах в системе
 * при попытке обращения к шаблону - он его инициализирует (или берёт из кеша) и возвращает имя шаблона
 */
export default function templateRepository($templateCache) {
    return {
        pages: {
            get index() {
                return getFromCache('index-page.tpl.html', require('../controller/index-page.tpl.html'));
            },
            get login() {
                return getFromCache('login-page.tpl.html', require('../controller/login-page.tpl.html'));
            }
        }

    };

    function getFromCache(templateName, templateContent) {
        if (!$templateCache.get(templateName)) {
            $templateCache.put(templateName, templateContent);
        }
        return templateName;
    }
}

templateRepository.$inject = ['$templateCache'];