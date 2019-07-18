// https://stackoverflow.com/questions/45777169/jenkinsfile-conditional-stage-execution-in-the-script-pipeline-syntax?rq=1
// thanks Yogesh and culmat
import org.jenkinsci.plugins.pipeline.modeldefinition.Utils

def call(name, execute, block) {
    return stage(name, execute ? block : {
        echo "skipped stage $name"
        Utils.markStageSkippedForConditional(STAGE_NAME)
    })
}
